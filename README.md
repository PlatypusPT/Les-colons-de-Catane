# Les princes de Catane

Lien vers Trello : https://trello.com/b/0f1oRtlF/les-princes-de-catane

Tuto JavaFX : https://openclassrooms.com/courses/les-applications-web-avec-javafx

Règles des princes de Catane : http://www.ludism.fr/regles_files/fr/LesColonsdeCathane_Jeudecartes_2_joueurs.pdf

Règles vidéo : https://www.youtube.com/watch?v=b0sXXHLP7C4

Pourquoi avoir choisi JavaFX ?
- Possibilité via des fichiers fxml (xml) de définir la partie vue du pattern MVC de façon déclarative
- Binding : mise en relation de propriétés selon le pattern Observable/Observer
- Contrôle du look and feel grâce à des feuilles de style basées sur les CSS
- Support de media audio et vidéo avec un Node dédié à cela : MediaView
- Intégration simple de contenus HTML avec le Node WebView
- Animation des objets graphiques de la scène
- Le rendu s'appuie sur l'accélération matérielle
- L'outil Scene Builder permet de construire l'IHM en glissant/déposant les contrôles et autres containers
- Support multitouch
- Modélisation 3D
- JavaFX est fourni avec le jdk depuis la dernière version (Java 8)
- JavaFX bénéficie des fonctionalités introduites dans Java 8 (lambdas, stream, parallélisme, ...)
- Il est possible d'intégrer Swing dans JavaFX
- JavaFX peut être déployé en tant que client lourd, client intégré dans un navigateur
- Les OS cibles possibles sont Windows, MAC; Linux, ARM (raspberry pi par exemple)

Fonctionnement de Trello :
- Bac à sable : dans celui-ci, on est censé contenir l'ensemble des fonctionnalités (par exemple cartes terrains).
- Bac de culture : il est censé contenir les détails des fonctionnalités (par exemple une carte terrain contient des ressources).
- Bac de départ ne concerne que le PO : il doit contenir les fiches auxquelles des modifications auraient été apportées.
- Le PO déplace ensuite certaines fiches dans 'To Do' (une répartition sera faite).
- Quand vous prenez une fiche, vous la déplacez dans 'En cours' et une fois terminée vous la déplacez dans 'Done'.
- Ensuite le PO vérifie le respect des consignes de la fiche et si elle est validée elle est placée dans le bac de récolte, sinon elle est placée dans bac de mauvaise récolte et il faut qu'elle reparte dans ToDo au plus vite et est à faire en priorité.
