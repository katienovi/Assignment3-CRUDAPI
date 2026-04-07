<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Details</title>

    
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/js/bootstrap.bundle.min.js" integrity="sha384-FKyoEForCGlyvwx9Hj09JcYn3nv7wiPVlz7YYwJrWVcXK/BmnVDxM+D2scQbITxI" crossorigin="anonymous"></script>

    <link rel = "stylesheet" href = "/css/style.css">

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
          <a class="nav-link" aria-current="page" href="/characters">Home</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/characters/about">About</a>
        </li>
        <li class="nav-item">
          <a class="nav-link" href="/characters/add">Add a character</a>
        </li>
      </ul>
    </div>
  </div>
</nav>

<!--Content-->
<div class="card mb-3 mx-auto" style="max-width: 540px;">
  <div class="row g-0">
    <div class="col-md-4">
      <img src="/Images/junimo-details.jpg" class="img-fluid rounded-start" alt="...">
    </div>
    <div class="col-md-8">
      <div class="card-body">
        <h5 class="card-title"> More about ${character.name} </h5>
        <p class="card-text">Character ID: ${character.characterID}</p>
        <p class="card-text"> ${character.description} </p>
        <p class="card-text">Loved gift: ${character.lovedGift}</p>
        <p class="card-text"></p>
        <p class="card-text"><small class="text-muted">Can you marry them? --> ${character.marriageStatus}</small></p>
      </div>
    </div>
  </div>
  <div class="alert alert-primary" role="alert" style="margin-top: 10px;"> Edit Character</div>
  <form id="edit-character" action="/characters/update/${character.characterID?c}" method="post" enctype="multipart/form-data">
      <input type="text" id="characterID" name="characterID" value="${character.characterID}" readonly />
      <input type="text" id="name" name="name" value="${character.name}" placeholder="Name" />
      <input type="text" id="lovedGift" name="lovedGift" value="${character.lovedGift}" placeholder="Loved gift" />
      <input type="text" id="marriageStatus" name="marriageStatus" value="${character.marriageStatus}" placeholder="Marriage status" />
      <input type="text" id="description" name="description" value="${character.description}" placeholder="Short description" />
      <label for="picture" class="form-label"> Picture:</label>
      <input type="file" id="picture" name="picture" />
      <button id = "submit" type="submit" class="btn btn-success">Save</button>
    </form>
    <br>
    <div class="alert alert-danger" role="alert">
      Delete Character
      <a style="float: right;" href="/characters/delete/${character.characterID?c}" class="btn btn-danger">Delete</a>
    </div>
</div>

<img src="/Images/krobus-blushing.png">


<div class="card">
  <div class="card-body">
    <blockquote class="blockquote mb-0">
      <p>“The glow of summer has faded, now...
        <br>and the moonlight jellies carry on toward the great unknown.”</p>
      <footer class="blockquote-footer">Dance of the Moonlight Jellies</footer>
    </blockquote>
  </div>
</div>


</body>
</html>