# MAPD

PROJET IMT ATLANTIQUE

Différences avec la conception:
Oubli de la méthode empty() dans la classe Place: les arcs n'ont pas accès au nb de Jetons de Place. Cela pose problème pour les arcs Empty: ils ne peuvent pas vider les places avec subTokens(int) s'ils n'ont pas accès au nb de jetons à soustraire...
Oubli de la redéfinition de isFireable() dans la classe Zero, et en conséquence besoin d'une méthode isEmpty() dans place


Affichage:
Considérant qu'une place n'as pas a savoir si elle possède des arc entsrant ou sortant nous avons choisit de ne pas afficher cette donné. 
