import requests
import csv
import json

# Define base URL and endpoint
base_url = 'http://localhost:9966/petclinic/api'
endpoint = '/owners'

# Function to send request and handle response
def add_owner(data):
    url = f'{base_url}{endpoint}'
    headers = {'accept': 'application/json', 'Content-Type': 'application/json'}
    response = requests.post(url, headers=headers, json=data)
    return response.json(), response.status_code

# Main function
def main():
    # Open CSV file for writing
    with open('pet_clinic.csv', 'w', newline='', encoding='utf-8') as csvfile:
        fieldnames = ['testCaseId', 'queryParameters', 'operationId', 'path', 'httpMethod', 'headerParameters',
                      'pathParameters', 'formParameters', 'bodyParameter', 'statusCode', 'responseBody']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        for i in range(200):  # Send 200 requests
            owner_data = {
                "firstName": f"basu_{i}",
                "lastName": "Franklin",
                "address": "110 W. Liberty St.",
                "city": "Madison",
                "telephone": "6085551023"
            }
            response_data, status_code = add_owner(owner_data)
            print(f"Request {i+1} - Status Code: {status_code}")

            writer.writerow({
                'testCaseId': i + 1,
                'queryParameters': '',
                'operationId': 'base',
                'path': endpoint,  # Corrected path
                'httpMethod': 'POST',  # Corrected HTTP method
                'headerParameters': json.dumps({'accept': 'application/json', 'Content-Type': 'application/json'}),
                'pathParameters': '',  # No path parameters for this request
                'formParameters': '',
                'bodyParameter': json.dumps(owner_data),
                'statusCode': status_code,
                'responseBody': json.dumps(response_data)
            })

if __name__ == '__main__':
    main()
