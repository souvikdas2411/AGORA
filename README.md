# Questions/Findings

- GenerateInstrumentation fails when using oas spec file if not in a swagger format. Happens during the initial replication study.
- Why use OAS spec file? AGORA checks the values inside the response, for example, if a 200 respose is returned by getAlbumTracks endpoint, and it says "total_tracks = 15" but there are 16 tracks AGORA will help us detect that. The OAS spec file is used to establish a baseline of status codes and data types.

