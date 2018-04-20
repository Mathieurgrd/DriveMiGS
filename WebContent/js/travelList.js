  var array = [["Jean-Martin ", "21/04/2018", "Place du capitole","10:00"],
  				["Jean-Martin ", "21/04/2018", "Place du capitole","10:00"],
  				["Jean-Martin ", "21/04/2018", "Place du capitole","10:00"],
  				["Jean-Martin ", "21/04/2018", "Place du capitole","10:00"],
  				["Jean-Martin ", "21/04/2018", "Place du capitole","10:00"]];
                table = document.getElementById("table");

      

                for (var i = 0; i < array.length; i++)
                {
                    // create a new row
                    var newRow = table.insertRow(table.length);
                     newRow.onclick = function () {
                            alert("ca marche");
                        };

                    for (var j = 0; j < array[i].length; j++)
                    {
                        // create a new cell
                        var cell = newRow.insertCell(j);


                        // add value to the cell
                        cell.innerHTML = array[i][j];
                    }
                }

                function addRowHandlers() {
                    var table = document.getElementById("table");
                    for (var i = 0, row; row = table.rows[i]; i++) {
                        //iterate through rows
                        //rows would be accessed using the "row" variable assigned in the for loop
                       
                    }
                    
                    addRowHandlers();

                
                }