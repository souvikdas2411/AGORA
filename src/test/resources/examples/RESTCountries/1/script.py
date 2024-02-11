import requests
import csv
import json

# Define base URL and endpoint
base_url = 'https://restcountries.com/v3.1'
endpoint = '/name/{name}'

# Sample country names
country_names = ['Canada', 'Mexico']

# Function to send request and handle response
def get_country_info(country_name):
    url = f'{base_url}{endpoint}'.format(name=country_name)
    response = requests.get(url)
    if response.status_code == 200:
        return response.json()
    else:
        return {'status': response.status_code, 'message': response.reason}

# Main function
def main():
    # Open CSV file for writing
    with open('src/test/resources/examples/RestCountries/1/country_info.csv', 'w', newline='', encoding='utf-8') as csvfile:
        fieldnames = ['testCaseId', 'queryParameters', 'operationId', 'path', 'httpMethod', 'headerParameters', 
                      'pathParameters', 'formParameters', 'bodyParameter', 'statusCode', 'responseBody']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        # Loop through country names
        for i, country_name in enumerate(country_names):
            country_info = get_country_info(country_name)
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
                'statusCode': 200,
                'responseBody': response_body
            })

if __name__ == '__main__':
    main()
