
import requests
import csv
import json

# Define base URL
base_url = 'http://localhost:9966/petclinic/api'
endpoint = '/owners/{owner_id}'

# Function to create owner and return ID
def create_owner():
    owner_data = {
        "firstName": "basu",
        "lastName": "Franklin",
        "address": "110 W. Liberty St.",
        "city": "110 W",
        "telephone": "6085551023"
    }
    url = f'{base_url}/owners'
    headers = {
        'accept': 'application/json',
        'Content-Type': 'application/json'
    }
    response = requests.post(url, headers=headers, json=owner_data)
    if response.status_code == 201:
        return response.json()['id']
    else:
        return None

# Function to fetch owner information by ID
def get_owner_info(owner_id):
    url = f'{base_url}/owners/{owner_id}'
    response = requests.get(url)
    if response.status_code in [200, 404]:
        return response.json(), response.status_code
    else:
        return {'status': response.status_code, 'message': response.reason}, response.status_code

# Main function
def main():
    # Open CSV file for writing
    with open('C:/Users/bhagy/Documents/CS569SEAnalysis/finalProject/script/real_petclinic_owner_info_updated.csv', 'w', newline='', encoding='utf-8') as csvfile:
        fieldnames = ['testCaseId', 'operationId', 'path', 'httpMethod', 'statusCode', 'responseBody']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        # Create and fetch owners in a loop
        for i in range(50):  # Creating and fetching data for 50 owners
            owner_id = create_owner()
            if owner_id:
                owner_info, status = get_owner_info(owner_id)
                response_body = json.dumps(owner_info)
                writer.writerow({
                    'testCaseId': i,
                    'operationId': 'getOwnerInfo',
                    'path': endpoint,
                    'httpMethod': 'GET',
                    'statusCode': status,
                    'responseBody': response_body
                })
            print(f"Owner {i}: Creation and Fetch - Completed")

if __name__ == '__main__':
    main()
