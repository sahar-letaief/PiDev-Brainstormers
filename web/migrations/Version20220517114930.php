<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20220517114930 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE TABLE images_events (id INT AUTO_INCREMENT NOT NULL, id_event_id INT NOT NULL, user_id INT NOT NULL, image VARCHAR(255) NOT NULL, INDEX IDX_917D900C212C041E (id_event_id), INDEX IDX_917D900CA76ED395 (user_id), PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('ALTER TABLE images_events ADD CONSTRAINT FK_917D900C212C041E FOREIGN KEY (id_event_id) REFERENCES evenement (id)');
        $this->addSql('ALTER TABLE images_events ADD CONSTRAINT FK_917D900CA76ED395 FOREIGN KEY (user_id) REFERENCES user (id)');
        $this->addSql('ALTER TABLE commande DROP status, CHANGE prod prod LONGTEXT NOT NULL COMMENT \'(DC2Type:array)\', CHANGE code_postal code_postal INT NOT NULL, CHANGE tel tel INT NOT NULL');
        $this->addSql('ALTER TABLE product CHANGE image image VARCHAR(255) NOT NULL, CHANGE reference reference VARCHAR(255) NOT NULL');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('DROP TABLE images_events');
        $this->addSql('ALTER TABLE commande ADD status VARCHAR(50) DEFAULT NULL, CHANGE prod prod LONGTEXT DEFAULT NULL COMMENT \'(DC2Type:array)\', CHANGE code_postal code_postal INT DEFAULT NULL, CHANGE tel tel INT DEFAULT NULL');
        $this->addSql('ALTER TABLE product CHANGE image image VARCHAR(255) DEFAULT NULL, CHANGE reference reference VARCHAR(255) DEFAULT NULL');
    }
}
