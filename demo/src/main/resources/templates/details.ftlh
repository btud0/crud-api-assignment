
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


        <main class="container mt-4">
            <h1>${character.name}</h1>

            <div class="row g-4">
                <#if character.imageUrl?has_content>
                <div class="col-md-5">
                    <img src="/${character.imageUrl}" alt="${character.name}" class="img-fluid rounded">
                </div>
                </#if>
                <div class="col-md-7">
                    <h2>Key Details</h2>
                    <ul>
                        <li>Rank: ${character.rank}</li>
                        <li>Techniques: ${character.techniques}</li>
                        <li>${character.description}</li>
                    </ul>
                </div>
            </div>

            <div class="text-center mt-4">
                <a href="/characters/updateForm/${character.characterId}" class="btn btn-warning">Edit Character</a>
                <a href="/characters/delete/${character.characterId}" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete this character?');">Delete Character</a>
                <a href="/characters/all" class="btn btn-secondary">Back to Gallery</a>
            </div>
        </main>
        
    </body>


</html>