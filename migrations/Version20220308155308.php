<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20220308155308 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('CREATE TABLE communication (id INT AUTO_INCREMENT NOT NULL, sender_id INT NOT NULL, recipient_id INT NOT NULL, title VARCHAR(255) NOT NULL, message LONGTEXT NOT NULL, created_at DATETIME NOT NULL, is_read TINYINT(1) NOT NULL, INDEX IDX_F9AFB5EBF624B39D (sender_id), INDEX IDX_F9AFB5EBE92F8F78 (recipient_id), PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('CREATE TABLE reclamation (id INT AUTO_INCREMENT NOT NULL, reference_id INT DEFAULT NULL, clients_id INT DEFAULT NULL, title VARCHAR(255) NOT NULL, create_date DATE DEFAULT NULL, create_resolution DATE DEFAULT NULL, description LONGTEXT NOT NULL, status VARCHAR(255) DEFAULT NULL, INDEX IDX_CE6064041645DEA9 (reference_id), INDEX IDX_CE606404AB014612 (clients_id), PRIMARY KEY(id)) DEFAULT CHARACTER SET utf8mb4 COLLATE `utf8mb4_unicode_ci` ENGINE = InnoDB');
        $this->addSql('ALTER TABLE communication ADD CONSTRAINT FK_F9AFB5EBF624B39D FOREIGN KEY (sender_id) REFERENCES user (id)');
        $this->addSql('ALTER TABLE communication ADD CONSTRAINT FK_F9AFB5EBE92F8F78 FOREIGN KEY (recipient_id) REFERENCES user (id)');
        $this->addSql('ALTER TABLE reclamation ADD CONSTRAINT FK_CE6064041645DEA9 FOREIGN KEY (reference_id) REFERENCES commande (id)');
        $this->addSql('ALTER TABLE reclamation ADD CONSTRAINT FK_CE606404AB014612 FOREIGN KEY (clients_id) REFERENCES user (id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('DROP TABLE communication');
        $this->addSql('DROP TABLE reclamation');
    }
}
