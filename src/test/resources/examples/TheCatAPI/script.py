import csv
import requests
import json

# Function to make the POST request and save response to CSV
def make_vote(image_id, headers, data):
    url = "https://api.thecatapi.com/v1/votes"
    response = requests.post(url, headers=headers, json=data)
    response_json = response.json()
    return response_json, response.status_code

def main():
    # Fetching image ids
    url = "https://api.thecatapi.com/v1/images/search?limit=200&api_key=live_ogfLUEXW60knN7kzh4jjf5VTdHDUbKFx5uAme8rmcKqQhjeYwHIf4XnfDUPzTuKS"
    response = requests.get(url)
    data = response.json()

    ids = [cat["id"] for cat in data]

    # Open CSV file for writing
    with open('src/test/resources/examples/TheCatApi/500/cat_info.csv', 'w', newline='', encoding='utf-8') as csvfile:
        fieldnames = ['testCaseId', 'queryParameters', 'operationId', 'path', 'httpMethod', 'headerParameters', 
                      'pathParameters', 'formParameters', 'bodyParameter', 'statusCode', 'responseBody']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()
    
        # Making vote and saving response for each id
        for i, cat_id in enumerate(ids):
            headers = {
                "Content-Type": "application/json",
                "x-api-key": "live_ogfLUEXW60knN7kzh4jjf5VTdHDUbKFx5uAme8rmcKqQhjeYwHIf4XnfDUPzTuKS"  # Replace with your actual API key
            }
            data = {
                "image_id": cat_id,
                "sub_id": "optional_unique_user_id",
                "value": 1
            }
            cat_info, status = make_vote(cat_id, headers, data)
            print("API Call " + str(i) + "\nStatus Code " + str(status))
            response_body = json.dumps(cat_info)
            writer.writerow({
                    'testCaseId': cat_id,
                    'queryParameters': '',
                    'operationId': 'v1Votes',
                    'path': '/votes',
                    'httpMethod': 'POST',
                    # 'headerParameters': json.dumps(headers),
                    'headerParameters': 'Content-Type=application/json;x-api-key=live_ogfLUEXW60knN7kzh4jjf5VTdHDUbKFx5uAme8rmcKqQhjeYwHIf4XnfDUPzTuKS',
                    'pathParameters': '',
                    'formParameters': '',
                    'bodyParameter': json.dumps(data),
                    # 'bodyParameter': '',
                    'statusCode': status,
                    'responseBody': response_body
                })

if __name__ == '__main__':
    main()
