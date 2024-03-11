import requests
import csv
import json
import random
import string

# Function to generate random string
def random_string(length):
    letters = string.ascii_letters
    return ''.join(random.choice(letters) for _ in range(length))

# Function to generate random phone number
def random_phone_number():
    return ''.join(random.choices(string.digits, k=10))

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
    with open('/Users/souvikdas/Desktop/OSU/CS569/AGORA/src/test/resources/examples/PetClinicInit/petClinicInit.csv', 'w', newline='', encoding='utf-8') as csvfile:
        fieldnames = ['testCaseId', 'queryParameters', 'operationId', 'path', 'httpMethod', 'headerParameters', 
                      'pathParameters', 'formParameters', 'bodyParameter', 'statusCode', 'responseBody']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        # Loop to make 1000 requests
        for i in range(1000):
            # Generate random owner data
            owner_data = {
                "firstName": random_string(8),
                "lastName": random_string(8),
                "address": f"{random_string(10)} {random_string(6)} St.",
                "city": random_string(6),
                "telephone": random_phone_number()
            }
            
            response_data, status_code = add_owner(owner_data)
            print(f"Request {i+1}: Status Code - {status_code}")

            writer.writerow({
                'testCaseId': i + 1,
                'queryParameters': '',
                'operationId': 'base',
                'path': endpoint,
                'httpMethod': 'POST',
                'headerParameters': json.dumps({'accept': 'application/json', 'Content-Type': 'application/json'}),
                'pathParameters': '',
                'formParameters': '',
                'bodyParameter': json.dumps(owner_data),
                'statusCode': status_code,
                'responseBody': json.dumps(response_data)
            })

if __name__ == '__main__':
    main()
