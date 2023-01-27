import { Request, response, Response, Router } from "express";
import { appendFile } from "fs";
import { request } from "http";
import path from "path";
import { UserController } from "../controller/UserController";


const routes = Router();

routes.get('/formularioCadastro', (req:Request, res:Response) => {
    res.sendFile(path.join(__dirname, '..', '..', 'src', 'view', 'SignUp.html'));
});

routes.get('/sucessCadastro', (req:Request, res:Response) => {
    res.sendFile(path.join(__dirname, '..', '..', 'src', 'view', 'SucessForms.html'));
});

routes.get('/Home', (req:Request, res:Response) => {
    res.sendFile(path.join(__dirname, '..', '..', 'src', 'view', 'Home.html'));
});

routes.post('/cadastroData', new UserController().addUser);

export default routes;