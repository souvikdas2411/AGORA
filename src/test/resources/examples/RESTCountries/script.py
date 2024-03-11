import requests
import csv
import json

# Define base URL and endpoint
base_url = 'https://restcountries.com/v3.1'
endpoint = '/name/{name}'

# Sample country names
country_names = [
    "Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria",
    "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan",
    "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Cambodia",
    "Cameroon", "Canada", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo (Congo-Brazzaville)", "Costa Rica",
    "Croatia", "Cuba", "Cyprus", "Czechia (Czech Republic)", "Democratic Republic of the Congo", "Denmark", "Djibouti", "Dominica", "Dominican Republic",
    "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Eswatini (fmr. 'Swaziland')", "Ethiopia", "Fiji", "Finland",
    "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea",
    "Guinea-Bissau", "Guyana", "Haiti", "Holy See", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran",
    "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati",
    "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania",
    "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius",
    "Mexico", "Micronesia", "Moldova", "Monaco", "Mongolia", "Montenegro", "Morocco", "Mozambique", "Myanmar (formerly Burma)", "Namibia",
    "Nauru", "Nepal", "Netherlands", "New Zealand", "Nicaragua", "Niger", "Nigeria", "North Korea", "North Macedonia (formerly Macedonia)", "Norway",
    "Oman", "Pakistan", "Palau", "Palestine State", "Panama", "Papua New Guinea", "Paraguay", "Peru", "Philippines", "Poland",
    "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Saint Kitts and Nevis", "Saint Lucia", "Saint Vincent and the Grenadines", "Samoa", "San Marino",
    "Sao Tome and Principe", "Saudi Arabia", "Senegal", "Serbia", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia", "Solomon Islands",
    "Somalia", "South Africa", "South Korea", "South Sudan", "Spain", "Sri Lanka", "Sudan", "Suriname", "Sweden", "Switzerland",
    "Syria", "Tajikistan", "Tanzania", "Thailand", "Timor-Leste", "Togo", "Tonga", "Trinidad and Tobago", "Tunisia", "Turkey",
    "Turkmenistan", "Tuvalu", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States of America", "Uruguay", "Uzbekistan", "Vanuatu",
    "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe", "Abkhazia", "China", "Kosovo", "Nagorno-Karabakh", "Northern Cyprus",
    "Somaliland", "South Ossetia", "Taiwan", "Transnistria", "Western Sahara",
    "Aland Islands", "Bonaire", "Curacao", "Saba", "Sint Eustatius", "Sint Maarten",
    "American Samoa", "Cook Islands", "Falkland Islands", "Faroe Islands", "French Guiana", "French Polynesia",
    "Gibraltar", "Greenland", "Guam", "Guernsey", "Isle of Man", "Jersey", "Martinique", "Mayotte", "Montserrat",
    "New Caledonia", "Niue", "Norfolk Island", "Northern Mariana Islands", "Pitcairn Islands", "Puerto Rico", "Reunion", "Saint Barthelemy",
    "Saint Helena", "Saint Martin", "Saint Pierre and Miquelon", "Saint Vincent and the Grenadines", "South Georgia and the South Sandwich Islands", "Svalbard and Jan Mayen",
    "Tokelau", "Turks and Caicos Islands", "United States Minor Outlying Islands", "Virgin Islands, British", "Virgin Islands, U.S.", "Wallis and Futuna"
]


# Function to send request and handle response
def get_country_info(country_name):
    url = f'{base_url}{endpoint}'.format(name=country_name)
    response = requests.get(url)
    if (response.status_code == 200 or response.status_code == 404):
        return response.json(), response.status_code
    else:
        return {'status': response.status_code, 'message': response.reason}

# Main function
def main():
    # Open CSV file for writing
    with open('src/test/resources/examples/RestCountries/100/country_info.csv', 'w', newline='', encoding='utf-8') as csvfile:
        fieldnames = ['testCaseId', 'queryParameters', 'operationId', 'path', 'httpMethod', 'headerParameters', 
                      'pathParameters', 'formParameters', 'bodyParameter', 'statusCode', 'responseBody']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        # Loop through country names
        for i, country_name in enumerate(country_names):
            country_info, status = get_country_info(country_name)
            print("API Call " + str(i) + "\nStatus Code " + str(status))
            response_body = json.dumps(country_info)
            writer.writerow({
                'testCaseId': i,
                'queryParameters': '',
                'operationId': 'v3Name',
                'path': '/name/{name}',
                'httpMethod': 'GET',
                'headerParameters': '',
                'pathParameters': f'name={country_name}',
                'formParameters': '',
                'bodyParameter': '',
                'statusCode': status,
                'responseBody': response_body
            })

if __name__ == '__main__':
    main()