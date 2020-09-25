const express = require('express');
const mongoose = require('mongoose');
const cors = require('cors');

const app = express();

app.use(cors());

mongoose.connect("mongodb+srv://jordan:Robert_04@graphqlcluster.4irdb.gcp.mongodb.net/GraphQLCluster?retryWrites=true&w=majority");
mongoose.connection.once('open', () => {
    console.log("connected to DB");
});


app.listen(4000, ()=>{
    console.log('now listening for requests on port 4000');
});

