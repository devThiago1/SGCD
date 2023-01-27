import { Request, response, Response, Router } from "express";
import { appendFile } from "fs";
import { request } from "http";
import path from "path";

const staticRoutes = Router();


staticRoutes.get('/public/css/signUp.css', (req:Request, res:Response) => {
    res.sendFile(path.join(__dirname, '..', '..', 'src', 'public', 'css' ,'signUp.css'));
});
    
staticRoutes.get('/public/css/sucessForms.css', (req:Request, res:Response) => {
    res.sendFile(path.join(__dirname, '..', '..', 'src', 'public', 'css' ,'sucessForms.css'));
});
    
staticRoutes.get('/public/css/home.css', (req:Request, res:Response) => {
    res.sendFile(path.join(__dirname, '..', '..', 'src', 'public', 'css' ,'home.css'));
});

staticRoutes.get('/public/logoSGCD-removebg-preview.png', (req:Request, res:Response) => {
    res.sendFile(path.join(__dirname, '..', '..', 'src', 'public' ,'logoSGCD-removebg-preview.png'));
});

staticRoutes.get('/public/background.png', (req:Request, res:Response) => {
    res.sendFile(path.join(__dirname, '..', '..', 'src', 'public' ,'background.png'));
});

staticRoutes.get('/public/example.png', (req:Request, res:Response) => {
    res.sendFile(path.join(__dirname, '..', '..', 'src', 'public' ,'example.png'));
});

staticRoutes.get('/public/sucess-card.png', (req:Request, res:Response) => {
    res.sendFile(path.join(__dirname, '..', '..', 'src', 'public' ,'sucess-card.png'));
});

staticRoutes.get('/public/app-card.png', (req:Request, res:Response) => {
    res.sendFile(path.join(__dirname, '..', '..', 'src', 'public' ,'app-card.png'));
});

staticRoutes.get('/public/celular-desc.png', (req:Request, res:Response) => {
    res.sendFile(path.join(__dirname, '..', '..', 'src', 'public' ,'celular-desc.png'));
});

staticRoutes.get('/public/eficiencia-card.png', (req:Request, res:Response) => {
    res.sendFile(path.join(__dirname, '..', '..', 'src', 'public' ,'eficiencia-card.png'));
});

staticRoutes.get('/public/relogio-card.png', (req:Request, res:Response) => {
    res.sendFile(path.join(__dirname, '..', '..', 'src', 'public' ,'relogio-card.png'));
});

staticRoutes.get('/public/user.png', (req:Request, res:Response) => {
    res.sendFile(path.join(__dirname, '..', '..', 'src', 'public' ,'user.png'));
});


export default staticRoutes;