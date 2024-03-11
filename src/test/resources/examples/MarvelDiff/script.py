import requests
import csv
import json
import hashlib
import time

# Define base URL
base_url = 'http://gateway.marvel.com/v1/public'
endpoint = '/characters/'

# Marvel API credentials
api_key = '685a5a9a4949dfc1370467bec5adc742'
private_key = '0f5ddaa3ed7406c48e2c1a43575f915cd594cfc2'

# Function to generate MD5 hash as a hex string
def generate_hash(ts, private_key, api_key):
    hash_input = f'{ts}{private_key}{api_key}'.encode('utf-8')
    md5_hash = hashlib.md5(hash_input)
    return md5_hash.hexdigest()

# Function to send request and handle response
def get_marvel_character(character_id):
    ts = str(int(time.time()))
    hash_value = generate_hash(ts, private_key, api_key)
    url = f'{base_url}{endpoint}{character_id}?apikey={api_key}&hash={hash_value}&ts={ts}'
    response = requests.get(url)
    return response.json(), response.status_code

# Main function
def main():
    # Open CSV file for writing
    # /Users/souvikdas/Desktop/OSU/CS569/AGORA/src/test/resources/examples/MarvelDiff/characterId
    with open('marvel_characters_100.csv', 'w', newline='', encoding='utf-8') as csvfile:
        fieldnames = ['testCaseId', 'queryParameters', 'operationId', 'path', 'httpMethod', 'headerParameters',
                      'pathParameters', 'formParameters', 'bodyParameter', 'statusCode', 'responseBody']
        writer = csv.DictWriter(csvfile, fieldnames=fieldnames)
        writer.writeheader()

        character_ids = [
            1011334, 1017100, 1009664, 1016823, 1009718, 1009220, 1009662, 1010755, 1011490, 1009351,
            1010810, 1009610, 1009187, 1009268, 1009282, 1011010, 1011176, 1010686, 1011297, 1011031,
            1009368, 1010756, 1010354, 1010846, 1011298, 1011034, 1009189, 1011178, 1009277, 1009466,
            1009262, 1009384, 1009465, 1009726, 1010699, 1009257, 1010338, 1009356, 1010745, 1009267,
            1009497, 1009567, 1009652, 1009521, 1010747, 1011396, 1010816, 1009281, 1011023, 1009535,
            1010748, 1010346, 1011289, 1010351, 1010784, 1011036, 1009663, 1009297, 1010870, 1009490,
            1009435, 1009366, 1009337, 1010370, 1010366, 1010840, 1011299, 1009492, 1010355, 1011299,
            1009552, 1009376, 1010725, 1011279, 1011361, 1009276, 1010352, 1010682, 1010985, 1010334,
            1009471, 1011072, 1009274, 1010848, 1011060, 1011073, 1009299, 1009367, 1010371, 1011276,
            1009265, 1011298, 1010773, 1009271, 1010827, 1010675, 1009343, 1010336, 1010826, 1009263,
            1009260, 1011266, 1009383, 1010746, 1009399, 1011253, 1009272, 1009499, 1009389, 1009421,
            1011136, 1011262, 1011301, 1009283, 1009378, 1011285, 1010718, 1009445, 1011324, 1010856,
            1010763, 1009424, 1011321, 1011038, 1010876, 1011362, 1009472, 1009495, 1011229, 1009475,
            1011344, 1009463, 1011266, 1011354, 1009553, 1010981, 1009596, 1009522, 1011214, 1009448,
            1011066, 1011237, 1009599, 1011198, 1009476, 1011131, 1009546, 1011275, 1011002, 1010770,
            1011070, 1009498, 1009516, 1011382, 1010847, 1009493, 1009479, 1011255, 1011245, 1010866,
            1011294, 1009417, 1009563, 1009392, 1009515, 1011286, 1011360, 1011252, 1009452, 1011296,
            1011004, 1009407, 1009590, 1010862, 1010863, 1009431, 1009560, 1010830, 1010874, 1009495,
            1011028, 1010951, 1010792, 1010969, 1010798, 1011118, 1010789, 1011095, 1011014, 1010890,
            1011196, 1011076, 1011265, 1011197, 1010873, 1010819, 1011029, 1011164, 1010818, 1010871,
            1010953, 1010749, 1010987, 1011195, 1010948, 1011041, 1011193, 1010748, 1010906, 1010954,
            1011257, 1010975, 1011244, 1010776, 1010983, 1010914, 1010875, 1010865, 1010891, 1010986,
            1010879, 1010926, 1010988, 1010880, 1010881, 1011051, 1010916, 1011050, 1010917, 1011052,
            1010918, 1011053, 1010919, 1011054, 1010920, 1011055, 1010921, 1011056, 1010922, 1011057,
            1010923, 1011058, 1010924, 1011059, 1010925, 1011060, 1010927, 1011061, 1010928, 1011062,
            1010929, 1011063, 1010930, 1011064, 1010931, 1011065, 1010932, 1011066, 1010933, 1011067,
            1010934, 1011068, 1010935, 1011069, 1010936, 1011070, 1010937, 1011071, 1010938, 1011072,
            1010939, 1011073, 1010940, 1011074, 1010941, 1011075, 1010942, 1011076, 1010943, 1011077,
            1010944, 1011078, 1010945, 1011079, 1010946, 1011080, 1010947, 1011081, 1010949, 1011082,
            1010950, 1011083, 1010952, 1011084, 1010955, 1011085, 1010956
        ]

        # Loop through character IDs
        for i, character_id in enumerate(character_ids):
            character_info, status = get_marvel_character(character_id)
            print("API Call " + str(i) + "\nStatus Code " + str(status))
            response_body = json.dumps(character_info)
            writer.writerow({
                'testCaseId': character_id,
                'queryParameters': '',
                'operationId': 'characterId',
                'path': '/characters/{character_id}',
                'httpMethod': 'GET',
                'headerParameters': '',
                'pathParameters': f'characterId={character_id}',
                'formParameters': '',
                'bodyParameter': '',
                'statusCode': status,
                'responseBody': response_body
            })

if __name__ == '__main__':
    main()
