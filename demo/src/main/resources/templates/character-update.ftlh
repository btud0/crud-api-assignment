
<!DOCTYPE html>
<html lang="en">

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

        <main class="mt-4">
            <div class="row justify-content-center">
                <div class="col-md-8 col-lg-6">
                    <h1 class="text-center">Update Character</h1>
                    <p class="text-center text-muted">Edit the information below to update this character.</p>

                    <form action="/characters/update/${character.characterId}" method="post" enctype="multipart/form-data">
                        <div class="mb-3">
                            <label for="name" class="form-label">Character Name:</label>
                            <input
                            type="text"
                            id="name"
                            name="name"
                            class="form-control"
                            value="${character.name}"
                            >
                        </div>
                        <div class="mb-3">
                            <label for="techniques" class="form-label">Character's Techniques:</label>
                            <input
                            type="text"
                            id="techniques"
                            name="techniques"
                            class="form-control"
                            value="${character.techniques}"
                            >
                        </div>
                        <div class="mb-3">
                            <label for="picture" class="form-label">Character Image:</label>
                            <#if character.imageUrl?has_content>
                                <img src="/${character.imageUrl}" alt="${character.name}" class="d-block mb-2 img-thumbnail" style="max-height: 150px;">
                            </#if>
                            <input
                            type="file"
                            id="picture"
                            name="picture"
                            class="form-control"
                            >
                        </div>
                        <div class="mb-3">
                            <label for="description" class="form-label">Description:</label>
                            <input
                            type="text"
                            id="description"
                            name="description"
                            class="form-control"
                            value="${character.description}"
                            >
                        </div>
                        <div class="mb-3">
                            <label for="rank" class="form-label">Rank:</label>
                            <input
                            type="text"
                            id="rank"
                            name="rank"
                            class="form-control"
                            value="${character.rank}"
                            >
                        </div>

                        <div class="text-center mt-4">
                            <button type="submit" class="btn btn-primary">Update Character</button>
                            <a href="/characters/all" class="btn btn-secondary">Cancel</a>
                        </div>
                    </form>
                </div>
            </div>
        </main>
    </body>

</html>
