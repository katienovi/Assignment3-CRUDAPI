<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Index</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

</head>
<body>

<!--Nav-Bar-->
<nav class="navbar navbar-expand-lg bg-body-tertiary">
  <div class="container-fluid">
    <a class="navbar-brand" href="#">
        <img src="/Images/navbar.png" alt="logo" width="35" height="39" class="d-inline-block align-text-top">
    </a>
    <div class="collapse navbar-collapse" id="navbarNav">
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link active" aria-current="page" href="/characters">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/characters/about">About</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/characters/add">Add a character</a>
        </li>
      </ul>
    </div>
    <form class="d-flex" role="search">
      <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search"/>
      <button class="btn btn-outline-success" type="submit">Search</button>
    </form>
  </div>
</nav>



<!--Character Cards-->
<div class="row row-cols-1 row-cols-md-3 g-6">
<#list characterList as character>
  <div class="col">
    <div class="card h-100">
      <img src="/Images/${(character.profilePicturePath)!'avatar.png'}" class="card-img-top" alt="Image of ${character.name}">
      <div class="card-body">
        <a href="/characters/${character.characterID}" class="link-success">
        <h5 class="card-title">${character.name}</h5>
        </a>
        <p class="card-text">
                             <b>About:</b> ${character.description}
          </p>
      </div>
    </div>
  </div>
  </#list>



</body>
</html>