import { Request, response, Response, Router } from "express";
import { appendFile } from "fs";
import { request } from "http";
import { UserController } from "./controller/UserController";

const routes = Router();
    
routes.get('/formularioCadastro', (req:Request, res:Response) => {
    res.sendFile(__dirname + '/view/SignUp.html')
});
routes.get('/public/logoSGCD-removebg-preview.png', (req:Request, res:Response) => {
    res.sendFile(__dirname + '/public/logoSGCD-removebg-preview.png');
  });
routes.get('/public/user.png', (req:Request, res:Response) => {
    res.sendFile(__dirname + '/public/user.png');
});
routes.get('/public/css/signUp.css', (req:Request, res:Response) => {
    res.sendFile(__dirname + '/public/css/signUp.css');
  });
routes.get('/sucessCadastro',(req:Request, res:Response) => {
    res.sendFile(__dirname + '/view/SucessForms.html');
});
routes.get('/public/css/sucessForms.css', (req:Request, res:Response) => {
    res.sendFile(__dirname + '/public/css/sucessForms.css');
})
routes.post('/cadastroData', new UserController().addUser);



export default routes;