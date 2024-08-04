$(function() {
    // Disable city and pincode dropdowns initially
    $("#city").prop("disabled", true);
    $("#pincode").prop("disabled", true);

    $.ajax({
        type: "GET",
        url: "http://localhost:9090/getAllStateNames",
        dataType: "json",
        contentType: "application/json;charset=utf-8",
        success: function(states) {
            var stateDropdown = "<option value=''>Select State</option>";
            for (var i = 0; i < states.length; i++) {
                stateDropdown += "<option value='" + states[i] + "'>" + states[i] + "</option>";
            }
            $("#state").append(stateDropdown);

            $("#state").change(function() {
                var selectedState = $(this).val();
                if (selectedState) {
                    // Enable city dropdown
                    $("#city").prop("disabled", false);

                    $.ajax({
                        type: "GET",
                        url: "http://localhost:9090/getAllCityNames/" + selectedState,
                        dataType: "json",
                        contentType: "application/json;charset=utf-8",
                        success: function(cities) {
                            var cityDropdown = "<option value=''>Select City</option>";
                            for (var i = 0; i < cities.length; i++) {
                                cityDropdown += "<option value='" + cities[i] + "'>" + cities[i] + "</option>";
                            }
                            $("#city").empty().append(cityDropdown);
                            // Disable pincode dropdown until city is selected
                            $("#pincode").prop("disabled", true).empty().append("<option value=''>Select Pincode</option>");
                        }
                    });
                } else {
                    // If no state is selected, disable city and pincode dropdowns
                    $("#city").prop("disabled", true).empty().append("<option value=''>Select City</option>");
                    $("#pincode").prop("disabled", true).empty().append("<option value=''>Select Pincode</option>");
                }
            });

            $("#city").change(function() {
                var selectedCity = $(this).val();
                if (selectedCity) {
                    // Enable pincode dropdown
                    $("#pincode").prop("disabled", false);

                    // Fetch pincode options based on the selected city
                    $.ajax({
                        type: "GET",
                        url: "http://localhost:9090/getPinCode/" + selectedCity,
                        dataType: "json",
                        contentType: "application/json;charset=utf-8",
                        success: function(pincode) {
                            var pincodeDropdown = "<option value=''>Select Pincode</option>";
                            for (var i = 0; i < 1; i++) {
                                pincodeDropdown += "<option value='" + pincode + "'>" + pincode + "</option>";
                            }
                            $("#pincode").empty().append(pincodeDropdown);
                        }
                    });
                } else {
                    // If no city is selected, disable pincode dropdown
                    $("#pincode").prop("disabled", true).empty().append("<option value=''>Select Pincode</option>");
                }
            });
        }
    });
});
