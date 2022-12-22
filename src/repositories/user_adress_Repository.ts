import { AppDataSource } from "../data-source";
import { Adress } from "../entities/Adress";

export const user_info_Repository = AppDataSource.getRepository(Adress);