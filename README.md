# Contrôleur d'ascenseurs d'immeuble
Projet de Conception et Programmation Orientée Objet de 2ème année de DUT Info en JAVA. 

Il s'agit d'une représentation d'un système de contrôle d'ascenseurs.
Son rôle est de gérer les différentes requêtes en provenance des différents étages 
et les attribuer aux bons ascenseurs selon la situation.

## Installation 
Requis : Java 1.7+

- Ouvrir un terminal
- Se placer dans le dossier contenant projet.jar 
- java -jar projet.jar

## Exécution
Selectionnez un jeu de donnée (entrer 1, 2 ou 3) ou l'exécution libre (4).

### Jeu de données 1
Ce jeu de données sert à montrer les différentes options sur les ascenseurs ainsi que le bloquage d'un ascenseur
puis son débloquage.

### Jeu de données 2
Ce jeu de données sert de démonstration au choix d'attribution des requêtes externes par répartition équitable : 
l'écart-type ne sera jamais superieur a 1.
Ici, on a 6 ascenseurs et 8 requêtes donc seulement 2 ascenseurs auront 2 requetes et tous les autres 1.

### Jeu de données 3
Ce jeu de données sert de demonstration au choix d'attribution des requêtes externes par répartition intelligente : 
si un ascenseur peut prendre une requête sur le chemin, il le fait.
Le premier ascenseur a d'abord une requête interne pour l'étage 5, puis des requêtes externes sont générées. 
Parmis ces dernières, celle pour l'étage 1, direction haut et celle pour l'étage 4, direction haut lui conviennent.

### Jeu de données 4
Scénario libre.
- on commence par choisir un affichage console (entrer c) ou IHM (i).
- on choisit le nombre d'ascenseurs
- on choisit le nombre d'etages

#### Mode console
Pour chaque ascenseur, lui attribuer une option (ou pas) : 
- V pour l'option vitesse accrue 
- M pour la musique de fond
- N ou n'importe quelle touche pour un ascenseur normal sans option

A partir de là, commencent les iterations. 
A chaque iteration, on peut : 
- ajouter une requete externe (touche e) : 	
  - on sélectionne alors l'étage d'où provient la requête (entier)
  - puis la direction demandée (entrées valides : "haut" ou "bas")
- ajouter une requete interne (touche i) :	
  - on sélectionne alors l'étage destination (entier)
  - puis l'ascenseur en question (entier)
- executer une iteration (touche a) : 
  - l'affichage nous montre alors la cage d'ascenseur (représentée par des "|") et les ascenseurs avec un code particulier (M pour montant, D pour descendant, O pour ouvert, F pour fermé et B pour bloqué)
- afficher les requetes courantes par étage (touche r) 
- bloquer un ascenseur (touche b) :
  - on indique alors quel ascenseur on désire bloquer (entier)
- quitter la simulation en appuyant sur Q

#### Mode IHM
A partir de là, commencent les iterations. 
A chaque iteration, on peut : 
- ajouter une requete externe
  - indiquer l'étage (entier) et la direction (entrées valides : "haut" ou "bas") sur la premiere ligne
  - cliquer sur Créer Requete Externe
- ajouter une requete interne
  - indiquer l'étage (entier) et l'ascenseur concerné (entier) sur la deuxième ligne
  - cliquer sur Créer Requete Interne
- executer une iteration en cliquant sur Iteration 

L'affichage est assez explicit et se fait dans une fenêtre à part apparaissant par défaut à droite de la fenêtre de saisie des requêtes.

Une fenêtre affichant les requêtes courantes est également présente.

Pour quitter fermer une des 3 fenêtre suffit.


###### Développé par FC, CL, JM, AM
