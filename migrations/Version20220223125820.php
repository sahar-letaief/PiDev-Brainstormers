<?php

declare(strict_types=1);

namespace DoctrineMigrations;

use Doctrine\DBAL\Schema\Schema;
use Doctrine\Migrations\AbstractMigration;

/**
 * Auto-generated Migration: Please modify to your needs!
 */
final class Version20220223125820 extends AbstractMigration
{
    public function getDescription(): string
    {
        return '';
    }

    public function up(Schema $schema): void
    {
        // this up() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE reclamation DROP FOREIGN KEY FK_CE60640433E1689A');
        $this->addSql('DROP INDEX IDX_CE60640433E1689A ON reclamation');
        $this->addSql('ALTER TABLE reclamation CHANGE command_id reference_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE reclamation ADD CONSTRAINT FK_CE6064041645DEA9 FOREIGN KEY (reference_id) REFERENCES commande (id)');
        $this->addSql('CREATE INDEX IDX_CE6064041645DEA9 ON reclamation (reference_id)');
    }

    public function down(Schema $schema): void
    {
        // this down() migration is auto-generated, please modify it to your needs
        $this->addSql('ALTER TABLE reclamation DROP FOREIGN KEY FK_CE6064041645DEA9');
        $this->addSql('DROP INDEX IDX_CE6064041645DEA9 ON reclamation');
        $this->addSql('ALTER TABLE reclamation CHANGE reference_id command_id INT DEFAULT NULL');
        $this->addSql('ALTER TABLE reclamation ADD CONSTRAINT FK_CE60640433E1689A FOREIGN KEY (command_id) REFERENCES commande (id)');
        $this->addSql('CREATE INDEX IDX_CE60640433E1689A ON reclamation (command_id)');
    }
}
