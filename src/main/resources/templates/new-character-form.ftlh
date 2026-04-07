<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Form</title>

    
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
          <a class="nav-link active" href="/characters/add">Add a character</a>
        </li>
      </ul>
    </div>
  </div>
</nav>


<form id="new-character" action="/characters/" method="post" enctype="multipart/form-data">
      <input type="text" id="name" name="name" placeholder="Name" />
      <input type="text" id="lovedGift" name="lovedGift" placeholder="Loved gift" />
      <input type="text" id="marriageStatus" name="marriageStatus" placeholder="Marriage status" />
      <input type="text" id="description" name="description" placeholder="Short description" />
      <label for="picture" class="form-label"> Picture:</label>
      <input type="file" id="picture" name="picture" />
      <button id = "submit" type="submit" class="btn btn-success">Save</button>
      <a href="/characters" class="btn btn-outline-danger" id = "cancel">Cancel</a>
    </form>


<br>
<img src="/Images/footer.gif" width="1000">

</body>
</html>