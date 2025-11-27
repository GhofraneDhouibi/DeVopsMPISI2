package com.example.projetmpisi.bdd.stepdefinitions;

import com.example.projetmpisi.entity.User;
import com.example.projetmpisi.service.IUserService;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ContextConfiguration
public class UserStepDefinitions {

    @Autowired
    private IUserService userService;

    private User user;
    private ResponseEntity<?> response;

    @Before
    public void setup() {
        user = null;
    }

    @Given("un utilisateur avec l'id {int}, le nom {string} et l'email {string}")
    public void un_utilisateur_avec_l_id_le_nom_et_l_email(Integer id, String username, String email) {
        user = new User(id, username, email);
    }

    @When("j'ajoute cet utilisateur via l'API")
    public void j_ajoute_cet_utilisateur_via_l_api() {
        User savedUser = userService.saveUser(user);
        response = ResponseEntity.ok(savedUser);
    }

    @Then("la réponse doit contenir l'id {int} et le nom {string}")
    public void la_reponse_doit_contenir_l_id_et_le_nom(Integer id, String username) {
        User result = (User) response.getBody();
        assertNotNull(result);
        assertEquals(id, result.getId());
        assertEquals(username, result.getUsername());
    }

    @Given("des utilisateurs existent dans le système")
    public void des_utilisateurs_existent_dans_le_systeme() {
        userService.saveUser(new User(2, "Bob", "bob@example.com"));
    }

    @When("je consulte tous les utilisateurs via l'API")
    public void je_consulte_tous_les_utilisateurs_via_l_api() {
        List<User> users = userService.getAllUsers();
        response = ResponseEntity.ok(users);
    }

    @Then("je reçois une liste contenant au moins 1 utilisateur")
    public void je_recois_une_liste_contenant_au_moins_1_utilisateur() {
        List<?> users = (List<?>) response.getBody();
        assertTrue(users.size() >= 1);
    }
}
