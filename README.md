## Google Deployment
Details found here:
https://developers.google.com/workspace/add-ons/alternate-runtimes-quickstart

* deployment.json contains the plugin deatils. 
* To create the deployment:
  * `gcloud workspace-add-ons deployments create oxos_addon --deployment-file=deployment.json
    `
* To install deployment
  * `gcloud workspace-add-ons deployments install oxos_addon`
## To Start Server with ngrok
  `ngrok http --hostname=oxos.ngrok.io 8080 `
## Google Add-on Development
### Token Verifier
`https://www.googleapis.com/oauth2/v3/tokeninfo?id_token={token}`