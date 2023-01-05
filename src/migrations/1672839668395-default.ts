import { MigrationInterface, QueryRunner } from "typeorm";

export class default1672839668395 implements MigrationInterface {
    name = 'default1672839668395'

    public async up(queryRunner: QueryRunner): Promise<void> {
        await queryRunner.query(`CREATE TABLE \`adress\` (\`id\` int NOT NULL AUTO_INCREMENT, \`bairro_user\` text NOT NULL, \`rua_user\` text NOT NULL, \`complemento_user\` text NOT NULL, \`cep_user\` varchar(11) NOT NULL, \`number_adress_user\` varchar(7) NOT NULL, PRIMARY KEY (\`id\`)) ENGINE=InnoDB`);
        await queryRunner.query(`CREATE TABLE \`users\` (\`id_user\` int NOT NULL AUTO_INCREMENT, \`first_name_user\` varchar(40) NOT NULL, \`last_name_user\` varchar(40) NOT NULL, \`number_user\` varchar(30) NOT NULL, \`cpf_user\` varchar(20) NOT NULL, \`email_user\` text NOT NULL, \`password_user\` text NOT NULL, \`adressIdId\` int NULL, UNIQUE INDEX \`REL_a176a088dde3889f5d495d9a9d\` (\`adressIdId\`), PRIMARY KEY (\`id_user\`)) ENGINE=InnoDB`);
        await queryRunner.query(`ALTER TABLE \`users\` ADD CONSTRAINT \`FK_a176a088dde3889f5d495d9a9d6\` FOREIGN KEY (\`adressIdId\`) REFERENCES \`adress\`(\`id\`) ON DELETE NO ACTION ON UPDATE NO ACTION`);
    }

    public async down(queryRunner: QueryRunner): Promise<void> {
        await queryRunner.query(`ALTER TABLE \`users\` DROP FOREIGN KEY \`FK_a176a088dde3889f5d495d9a9d6\``);
        await queryRunner.query(`DROP INDEX \`REL_a176a088dde3889f5d495d9a9d\` ON \`users\``);
        await queryRunner.query(`DROP TABLE \`users\``);
        await queryRunner.query(`DROP TABLE \`adress\``);
    }

}
