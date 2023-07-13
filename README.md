<img width="755" alt="image" src="https://github.com/robertmo98/FreeGamesViewer/assets/107803618/b3a0ab5d-a62e-4b49-9594-3ac64d3f9660">
FreeGamesViewer - Android Application (final project).
July 2023
The Application presents free games, based on the api https://www.freetogame.com/api.
The user may choose to filter the presented information by clicking the requested options.

Main page:
<img width="214" alt="image" src="https://github.com/robertmo98/FreeGamesViewer/assets/107803618/0d8adf07-6294-46b8-96e4-e23edd6f7c6a">

There are three "paths" :
1) Navigate to the "Choose Platform" page:
   <img width="801" alt="image" src="https://github.com/robertmo98/FreeGamesViewer/assets/107803618/c8e3c2f0-d64d-4351-a2ff-55b97b77bad6">
   
   There are two options: games for PC and games for Browser, depending on the clicked option, the next page presents a Recycler-View
   consists of games for the selected platform. Clicking on any game will lead to the page that shows further information of the game.
   
3) Navigate to the "Choose Category" page:
   <img width="755" alt="image" src="https://github.com/robertmo98/FreeGamesViewer/assets/107803618/d175d954-71c4-4138-bad6-19da167115ad">
   
   The categories are presented in a RecyclerView.
   (The categories areretreived from the api, by extracting a list from the json of all the available games, since there is not endpoid that
   fits this requirement).
   Clicking on any game in the recycler will lead to the details page for the clicked item.
   A problem in the api leads to irellevant categories. The clicked category uses as a QUERY parameter for the GET request, however,
   the json retreived consists of games of different and irrelevant categories.
   
4) Navigate to the "Lateset Released Date" page:
   <img width="580" alt="image" src="https://github.com/robertmo98/FreeGamesViewer/assets/107803618/cd6bf873-fb35-415a-992b-6cba6c99c55b">

   This page displays the games sorted-by release date (newest to oldest) - for web and browser.
   Clicking on any game will lead to the details page.

   

libraries: 
Picasso 
Retrofit

Design patter: MVVM

The data of games is based on the free api - https://www.freetogame.com/api , with gratitude to the "freetogame" team .
