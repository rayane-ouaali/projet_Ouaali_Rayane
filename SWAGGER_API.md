# Documentation SimpleCash v4

## Accès à Swagger UI

Une fois l'application démarrée, accédez à la documentation interactive Swagger :

```
http://localhost:8080/swagger-ui.html
```

Ou directement via OpenAPI JSON :
```
http://localhost:8080/v3/api-docs
```

---

## Routes disponibles

### **Conseillers** (Lecture + Association)

#### GET /conseillers
Récupère la liste de tous les conseillers

**Réponse (200):**
```json
[
  {
    "id": 1,
    "nom": "Jean Dupont"
  }
]
```

#### GET /conseillers/{id}
Récupère un conseiller par ID

**Paramètres:**
- `id` (path, required): ID du conseiller

**Réponse (200):**
```json
{
  "id": 1,
  "nom": "Jean Dupont"
}
```

**Réponse (404):** Conseiller non trouvé

#### POST /conseillers/{conseillerID}/clients/{clientId}
Ajoute un client à un conseiller

**Paramètres:**
- `conseillerID` (path, required): ID du conseiller
- `clientId` (path, required): ID du client

**Réponse (200):** Succès

**Réponse (400):** Conseiller ou Client non trouvé

---

### **Clients** (CRUD complet)

#### POST /clients
Crée un nouveau client

**Body (application/json):**
```json
{
  "nom": "Ouaali",
  "prenom": "Rayane",
  "adresse": "123 Rue de Paris",
  "codePostal": "75001",
  "ville": "Paris",
  "telephone": "0123456789",
  "idConseiller": 1
}
```

**Réponse (201):**
```json
{
  "id": 1,
  "nom": "Ouaali",
  "prenom": "Rayane",
  "adresse": "123 Rue de Paris",
  "codePostal": "75001",
  "ville": "Paris",
  "telephone": "0123456789",
  "idConseiller": 1
}
```

**Réponse (400):** Erreur de validation

---

#### GET /clients
Récupère la liste de tous les clients

**Réponse (200):**
```json
[
  {
    "id": 1,
    "nom": "Ouaali",
    "prenom": "Rayane",
    "adresse": "123 Rue de Paris",
    "codePostal": "75001",
    "ville": "Paris",
    "telephone": "0123456789",
    "idConseiller": 1
  }
]
```

---

#### GET /clients/{id}
Récupère un client par ID

**Paramètres:**
- `id` (path, required): ID du client

**Réponse (200):**
```json
{
  "id": 1,
  "nom": "Ouaali",
  "prenom": "Rayane",
  "adresse": "123 Rue de Paris",
  "codePostal": "75001",
  "ville": "Paris",
  "telephone": "0123456789",
  "idConseiller": 1
}
```

**Réponse (404):** Client non trouvé

---

#### PATCH /clients/{id}
Met à jour partiellement un client (les champs non renseignés ne sont pas modifiés)

**Paramètres:**
- `id` (path, required): ID du client

**Body (application/json) - Exemple partiel:**
```json
{
  "nom": "Nouveau Nom"
}
```

**Réponse (200):**
```json
{
  "id": 1,
  "nom": "Nouveau Nom",
  "prenom": "Rayane",
  "adresse": "123 Rue de Paris",
  "codePostal": "75001",
  "ville": "Paris",
  "telephone": "0123456789",
  "idConseiller": 1
}
```

**Réponse (404):** Client non trouvé

---

#### DELETE /clients/{id}
Supprime un client et désactive ses comptes associés

**Paramètres:**
- `id` (path, required): ID du client

**Réponse (204):** Succès (pas de contenu)

**Réponse (404):** Client non trouvé

---

### **Comptes** (Lecture + Transactions)

#### GET /comptes
Récupère la liste de tous les comptes

**Réponse (200):**
```json
[
  {
    "id": 1,
    "idClient": 1,
    "solde": 5000.0,
    "actif": true,
    "idTypeCompte": 1
  }
]
```

---

#### GET /comptes/{id}
Récupère un compte par ID

**Paramètres:**
- `id` (path, required): ID du compte

**Réponse (200):**
```json
{
  "id": 1,
  "idClient": 1,
  "solde": 5000.0,
  "actif": true,
  "idTypeCompte": 1
}
```

**Réponse (404):** Compte non trouvé

---

#### POST /comptes/{compteId}/transaction
Effectue une transaction sur un compte (dépôt ou retrait)

**Paramètres:**
- `compteId` (path, required): ID du compte
- `montant` (query, required): Montant de la transaction (positif pour dépôt, négatif pour retrait)

**Exemple:**
```bash
# Dépôt de 500
POST /comptes/1/transaction?montant=500

# Retrait de 200
POST /comptes/1/transaction?montant=-200
```

**Réponse (200):**
```json
{
  "id": 1,
  "idClient": 1,
  "solde": 5500.0,
  "actif": true,
  "idTypeCompte": 1
}
```

**Réponse (404):** Compte non trouvé

**Réponse (400):** Solde insuffisant (ne peut pas descendre sous -1000)

---

## Codes de réponse HTTP

| Code | Description |
|------|-------------|
| 200 | OK - Requête réussie |
| 201 | Created - Ressource créée |
| 204 | No Content - Suppression réussie |
| 400 | Bad Request - Erreur de validation |
| 404 | Not Found - Ressource non trouvée |
| 500 | Internal Server Error - Erreur serveur |

---

## Erreurs de validation

Les erreurs de validation retournent un statut **400** avec les détails des champs invalides :

```json
{
  "nom": "Le nom du client est obligatoire.",
  "telephone": "Le téléphone est obligatoire."
}
```

---

## Données initiales

Au démarrage de l'application, les données suivantes sont créées automatiquement :

- **1 Conseiller** : Jean Dupont
- **2 Types de Compte** : Compte Courant, Compte Épargne
- **1 Client** : Ouaali Rayane (associé à Jean Dupont)
- **2 Comptes** : 
  - Compte Courant (solde: 5000.0)
  - Compte Épargne (solde: 10000.0)

---

## Résumé des endpoints

| Méthode | Endpoint | Description |
|---------|----------|-------------|
| GET | `/conseillers` | Lister tous les conseillers |
| GET | `/conseillers/{id}` | Récupérer un conseiller |
| POST | `/conseillers/{conseillerID}/clients/{clientId}` | Ajouter un client à un conseiller |
| POST | `/clients` | Créer un client |
| GET | `/clients` | Lister tous les clients |
| GET | `/clients/{id}` | Récupérer un client |
| PATCH | `/clients/{id}` | Mettre à jour un client |
| DELETE | `/clients/{id}` | Supprimer un client |
| GET | `/comptes` | Lister tous les comptes |
| GET | `/comptes/{id}` | Récupérer un compte |
| POST | `/comptes/{compteId}/transaction` | Effectuer une transaction |

## Notes importantes

- **Client DELETE** : Supprime le client et désactive tous ses comptes associés (les comptes ne sont pas supprimés, seulement désactivés)
- **Client PATCH** : Permet les mises à jour partielles - les champs non renseignés ne sont pas modifiés
- **Transactions** : Les transactions peuvent être positives (dépôt) ou négatives (retrait). Le solde ne peut pas descendre sous -1000
- **Conseiller - Association** : Permet d'associer un client existant à un conseiller
- **TypeCompte** : Les types de compte sont créés au démarrage (Compte Courant, Compte Épargne)
