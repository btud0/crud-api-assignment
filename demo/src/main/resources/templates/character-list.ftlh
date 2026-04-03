
<!DOCTYPE html>
<html>

    <head>
        <!--Bootstrap css import link-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">



    </head>

    
    <!--Start of the body of the page-->
    <body class="bg-light">

        
         <!--Nav bar with bootstrap-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="/characters/all">Jujutsu Kaisen Gallery</a>
                    <div class="navbar-nav">
                        <a class="nav-link" href="/characters/all">Home</a>
                        <a class="nav-link" href="/characters/all">Details</a>
                        <a class="nav-link" href="/characters/about">About</a>
                        <a class="nav-link" href="/characters/add">New Character</a>
                    </div>
            </div>
        </nav>



        <main class="container">
            <h1>Character Gallery</h1>
            <p>Jujutsu Kaisen Character Gallery</p>

            <!--search bar html -->
            <div class="mb-4">
                <form action="/characters/search" method="get" class="mb-4">
                    <input
                    id="search"
                    name="name"
                    type="search"
                    class="form-control"
                    placeholder="Search by name or ability."
                    >
                </form>
            </div>

            <!-- bootstrap card grid system implementation-->
                <div class="row g-4" id="charactersGrid">
                    <#list characterList as character>
                        <div class="col-md-4 col-lg-3 character-card" data-name="${character.name?lower_case}" data-role="${character.rank?lower_case}">
                            <div class="card h-100">
                                <#if character.imageUrl?has_content>
                                    <img src="/${character.imageUrl}" class="card-img-top" alt="${character.name}">
                                </#if>
                                <div class="card-body">
                                    <h5 class="card-title">${character.name}</h5>
                                    <p class="card-text">
                                        Rank: ${character.rank}<br>
                                        Techniques: ${character.techniques}<br>
                                        ${character.description}
                                    </p>
                                    <a href="/characters/${character.characterId}" class="btn btn-primary">Character Details</a>
                                </div>
                            </div>
                        </div>
                    </#list>
                </div>
            
        </main>

        <!--JS logic for searchbar-->

    </body>


</html>