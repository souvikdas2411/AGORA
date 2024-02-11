import requests
import csv
import json

# Define base URL and endpoint
base_url = 'https://restcountries.com/v3.1'
endpoint = '/name/{name}'

# Sample country names
country_names = ["Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antigua and Barbuda", "Argentina", "Armenia", "Australia", "Austria",
    "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados", "Belarus", "Belgium", "Belize", "Benin", "Bhutan",
    "Bolivia", "Bosnia and Herzegovina", "Botswana", "Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burundi", "Cabo Verde", "Cambodia",
    "Cameroon", "Canada", "Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo (Congo-Brazzaville)", "Costa Rica",
    "Croatia", "Cuba", "Cyprus", "Czechia (Czech Republic)", "Democratic Republic of the Congo", "Denmark", "Djibouti", "Dominica", "Dominican Republic", "Ecuador",
    "Egypt", "El Salvador", "Equatorial Guinea", "Eritrea", "Estonia", "Eswatini", "Ethiopia", "Fiji", "Finland", "France",
    "Gabon", "Gambia", "Georgia", "Germany", "Ghana", "Greece", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau",
    "Guyana", "Haiti", "Honduras", "Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland",
    "Israel", "Italy", "Ivory Coast", "Jamaica", "Japan", "Jordan", "Kazakhstan", "Kenya", "Kiribati", "Kosovo",
    "Kuwait", "Kyrgyzstan", "Laos", "Latvia", "Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania",
    "Luxembourg", "Madagascar", "Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius"]

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
