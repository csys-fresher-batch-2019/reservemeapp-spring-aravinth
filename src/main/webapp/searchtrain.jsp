<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
<script>
​
function viewtrains(){
    let url = "http://http://localhost:8089/swagger-ui.html#/train-controller/listUsingGET";
    $.ajax({url:"http://http://localhost:8089/swagger-ui.html#/train-controller/listUsingGET",success: function(data)}){
    $.getJSON(url, function(data){
        let trains = data;
        console.log(trains.length);
        console.table(trains);
      displaytrains(trains);
​
    });
	console.log("View trains completed");
	}
​
    function displaytrains(trains){
​
        $("#trainTbl").empty();
        let i = 0;
        var content = "";
        for(let p of trains){
            i = i +1;
            var row = `<tr><td>${i}</td><td>${p.train_num}</td><td>${p.train_name}</td>
            <td>${p.price}</td><td>${p.travelling_time}</td><td>${p.seats}</td>
           <td><a href="book.html" class="btn btn-success">Book</a>
            </td>
            </tr>`;
            content = content + row;
        }
        $("#trainTbl").append(content);
        
    
}
</script>
</head>
​
<body>
    <nav class="navbar navbar-expand navbar-dark bg-dark">
        <div class="nav navbar-nav">
            <a class="nav-item nav-link active" href="#">Home <span class="sr-only">(current)</span></a>
            <a class="nav-item nav-link" href="#">List trains</a>
        </div>
    </nav>
    <div id="container">
    <h3>List Trains API</h3>
    <button onclick="viewtrains()"> Display trains</button>
    <table border="1" class="table table-bordered">
        <thead><tr><th>#</th><th>TrainNumber</th><th>Trainname</th><th>Price</th><th>Travellingtime</th><th>Seats</th>
        <th>Action</th></tr></thead>
        <tbody id="trainTbl">
​
​
        </tbody>
    </table>
</div>
</body>
</html>