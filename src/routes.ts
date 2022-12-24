import { Request, Response, Router } from "express";
import { appendFile } from "fs";
import { UserController } from "./controller/UserController";

const routes = Router();
    
routes.get('/formularioCadastro', (req:Request, res:Response) => {
    res.sendFile(__dirname + '/view/SignUp.html')
});
routes.get('/public/logoSGCD-removebg-preview.png', (req:Request, res:Response) => {
    res.sendFile(__dirname + '/public/logoSGCD-removebg-preview.png');
  });
routes.get('/public/css/signUp.css', (req:Request, res:Response) => {
    res.sendFile(__dirname + '/public/css/signUp.css');
  });
routes.post('/cadastroData', new UserController().addUser);


export default routes;