Feature: Gestion des utilisateurs
  En tant qu'administrateur
  Je veux pouvoir gérer les utilisateurs via l'API REST
  Afin de vérifier que les endpoints fonctionnent correctement

  Scenario: Ajouter un nouvel utilisateur
    Given un utilisateur avec l'id 1, le nom "Alice" et l'email "alice@example.com"
    When j'ajoute cet utilisateur via l'API
    Then la réponse doit contenir l'id 1 et le nom "Alice"

  Scenario: Récupérer la liste des utilisateurs
    Given des utilisateurs existent dans le système
    When je consulte tous les utilisateurs via l'API
    Then je reçois une liste contenant au moins 1 utilisateur
