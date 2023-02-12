import  express  from "express";
import { AppDataSource } from "./data-source";
import routes from "./routes/home";
import staticRoutes from './routes/static';
import 'dotenv/config';
import 'reflect-metadata';


AppDataSource.initialize().then(() => {
    const app = express();
    const bodyParser = require("body-parser");
    
    
    app.use(express.static('public'));
    app.use(bodyParser.urlencoded({ extended: true }));
    app.use(express.json());
    app.use(routes);
    app.use(staticRoutes);
    

    return app.listen(process.env.PORT);
});