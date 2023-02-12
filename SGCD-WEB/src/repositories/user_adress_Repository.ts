import { AppDataSource } from "../data-source";
import { Adress } from "../entities/Adress";

export const user_adress_Repository = AppDataSource.getRepository(Adress);