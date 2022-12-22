import { Router } from "express";
import { appendFile } from "fs";
import { UserController } from "./controller/UserController";

const routes = Router();
    
routes.post('/cadastro', new UserController().addUser);


export default routes;