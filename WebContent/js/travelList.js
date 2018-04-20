  var array = [["Jean-Martin ", "Latitude", "Longitude"],
            ["Jean-Martin ", "Latitude", "Longitude"],
            ["Jean-Martin ", "Latitude", "Longitude"],
            ["Jean-Martin ", "Latitude", "Longitude"],
            ["Jean-Martin ", "Latitude", "Longitude"], ],
                table = document.getElementById("table");

        /* Method 1
         // rows
         for(var i = 1; i < table.rows.length; i++)
         {
         // cells
         for(var j = 0; j < table.rows[i].cells.length; j++)
         {
         table.rows[i].cells[j].innerHTML = array[i - 1][j];
         }
         }
         */

        // Method 2

        for (var i = 0; i < array.length; i++)
        {
            // create a new row
            var newRow = table.insertRow(table.length);
            for (var j = 0; j < array[i].length; j++)
            {
                // create a new cell
                var cell = newRow.insertCell(j);
                

                // add value to the cell
                cell.innerHTML = array[i][j];
            }
        }