package liquibase.statement.generator;

import liquibase.database.Database;
import liquibase.database.SQLiteDatabase;
import liquibase.statement.ReindexStatement;
import liquibase.statement.syntax.Sql;
import liquibase.statement.syntax.UnparsedSql;

public class ReindexGeneratorSQLite implements SqlGenerator<ReindexStatement> {
    public int getSpecializationLevel() {
        return SPECIALIZATION_LEVEL_DATABASE_SPECIFIC;
    }

    public boolean isValidGenerator(ReindexStatement statement, Database database) {
        return (database instanceof SQLiteDatabase);
    }

    public GeneratorValidationErrors validate(ReindexStatement reindexStatement, Database database) {
        return new GeneratorValidationErrors();
    }

    public Sql[] generateSql(ReindexStatement statement, Database database) {
        return new Sql[] {
                new UnparsedSql("REINDEX "+database.escapeTableName(statement.getSchemaName(), statement.getTableName()))
        };
    }
}