# MAPD

Différences avec la conception:
Oubli de la méthode empty() dans la classe Place: les arcs n'ont pas accès au nb de Jetons de Place. Cela pose problème pour les arcs Empty: ils ne peuvent pas vider les places avec subTokens(int) s'ils n'ont pas accès au nb de jetons à soustraire...
