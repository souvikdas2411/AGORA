import requests
import csv
import json

# Define base URL and endpoint
base_url = 'https://restcountries.com/v3.1'
endpoint = '/lang/{lang}'

# Sample lang codes
lang_codes = [
    "Afrikaans"
]

# Function to send request and handle response
def get_country_info(lang_code):
    url = f'{base_url}{endpoint}'.format(lang=lang_code)
    response = requests.get(url)
    if (response.status_code == 200 or response.status_code == 404):
        return response.json(), response.status_code
    else:
        return {'status': response.status_code, 'message': response.reason}

# Main function
def main():
    # Open CSV file for writing
    with open('country_info_lang.csv', 'w', newline='', encoding='utf-8') as csvfile:
        fieldnames = ['testCaseId', 'queryParameters', 'operationId', 'path', 'httpMethod', 'headerParameters', 
                      'pathParameters', 'formParameters', 'bodyParameter', 'statusCode', 'responseBody']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        # Loop through country names
        for i, lang_code in enumerate(lang_codes):
            country_info, status = get_country_info(lang_code)
            print("API Call " + str(i) + "\nStatus Code " + str(status))
            response_body = json.dumps(country_info)
            writer.writerow({
                'testCaseId': i,
                'queryParameters': '',
                'operationId': 'v3Lang',
                'path': '/lang/{lang}',
                'httpMethod': 'GET',
                'headerParameters': '',
                'pathParameters': f'lang={lang_code}',
                'formParameters': '',
                'bodyParameter': '',
                'statusCode': status,
                'responseBody': response_body
            })

if __name__ == '__main__':
    main()