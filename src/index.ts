import  express  from "express";
import { AppDataSource } from "./data-source";
import routes from "./routes";
import 'dotenv/config';
import 'reflect-metadata';

AppDataSource.initialize().then(() => {
    const app = express();
    const bodyParser = require("body-parser");

    app.use(express.static('public'));
    app.use(bodyParser.json());
    app.use(bodyParser.urlencoded({ extended: true }));
    app.use(express.json());
    app.use(routes);

    return app.listen(process.env.PORT);
});