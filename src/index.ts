import  express  from "express";
import { AppDataSource } from "./data-source";

AppDataSource.initialize().then(() => {
    const app = express();
    const bodyParser = require("body-parser");


    app.use(bodyParser.json());
    app.use(bodyParser.urlencoded({ extended: true }));
    app.use(express.json());
    app.use();
});