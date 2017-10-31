package com.Tunes_Developers.Models;

/**
 * Created by Geoffrey-Kimani on 10/9/2017.
 */
public class EngineModel {
//    Database Strings
    private String connectionRemote = "";
    private String connectionLocalHost = "";
    private String createDatabase = "";
    private String dropDatabase = "";

//    Table Strings
    private String createTable = "";
    private String alterTable = "";
    private String dropTable = "";
    private String dropColumn = "";
    private String createTemporaryTable = "";

    //    Create Columns
    private String createBool = "";
    private String createDate = "";
    private String createTime = "";
    private String createDateTime = "";
    private String createTimestamp = "";
    private String createTimestamps = "";
    private String createDouble = "";
    private String createFloat = "";
    private String createJson = "";
    private String createCharacter = "";
    private String createStringConstrain = "";
    private String createString = "";
    private String createText = "";
    private String createMediumText = "";
    private String createInteger = "";
    private String createBigInteger = "";
    private String createSmallInteger = "";
    private String createTinyInteger = "";
    private String createDecimal = "";
    private String createIncrement = "";
    private String createIncrementConstrain = "";

//    Additional content when creating table
    private String makeDefault = "";
    private String makeNullable = "";
    private String makeUniqueIndex = "";
    private String makeUnsigned = "";
    private String makePrimaryKey = "";
    private String makeForeignKey = "";
    private String makeAutoIncrement = "";
    private String makeUnique = "";

//    Manipulate data and results
    private String selectFormat = "";
    private String whereFormat = "";
    private String orWhereFormat = "";
    private String whereThreeFormat = "";
    private String joinFormat = "";
    private String limitFormat = "";
    private String deleteSelectFormat = "";
    private String deleteFrom = "";

//    Manipulate records
    private String insertFormat = "";
    private String insertMultipleFormat = "";
    private String updateFormat = "";
    private String updateMultipleFormat = "";
    private String deleteFormat = "";

    public String getMakeAutoIncrement() {
        return makeAutoIncrement;
    }

    public String getDropTable() {
        return dropTable;
    }

    public String getCreateTemporaryTable() {
        return createTemporaryTable;
    }

    public String getDropColumn() {
        return dropColumn;
    }

    public String getCreateIncrement() {
        return createIncrement;
    }

    public String getCreateIncrementConstrain() {
        return createIncrementConstrain;
    }

    public String getCreateStringConstrain() {
        return createStringConstrain;
    }

    public String getConnectionRemote() {
        return connectionRemote;
    }

    public String getConnectionLocalHost() {
        return connectionLocalHost;
    }

    public String getCreateDatabase() {
        return createDatabase;
    }

    public String getDropDatabase() {
        return dropDatabase;
    }

    public String getCreateTable() {
        return createTable;
    }

    public String getCreateBool() {
        return createBool;
    }

    public String getCreateDate() {
        return createDate;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getCreateDateTime() {
        return createDateTime;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public String getCreateTimestamps() {
        return createTimestamps;
    }

    public String getCreateDouble() {
        return createDouble;
    }

    public String getCreateFloat() {
        return createFloat;
    }

    public String getCreateJson() {
        return createJson;
    }

    public String getCreateCharacter() {
        return createCharacter;
    }

    public String getCreateText() {
        return createText;
    }

    public String getCreateMediumText() {
        return createMediumText;
    }

    public String getCreateInteger() {
        return createInteger;
    }

    public String getCreateBigInteger() {
        return createBigInteger;
    }

    public String getCreateSmallInteger() {
        return createSmallInteger;
    }

    public String getCreateTinyInteger() {
        return createTinyInteger;
    }

    public String getCreateDecimal() {
        return createDecimal;
    }

    public String getAlterTable() {
        return alterTable;
    }

    public String getMakeDefault() {
        return makeDefault;
    }

    public String getMakeNullable() {
        return makeNullable;
    }

    public String getMakeUniqueIndex() {
        return makeUniqueIndex;
    }

    public String getMakeUnsigned() {
        return makeUnsigned;
    }

    public String getMakePrimaryKey() {
        return makePrimaryKey;
    }

    public String getMakeForeignKey() {
        return makeForeignKey;
    }

    public String getMakeUnique() {
        return makeUnique;
    }

    public String getSelectFormat() {
        return selectFormat;
    }

    public String getWhereFormat() {
        return whereFormat;
    }

    public String getOrWhereFormat() {
        return orWhereFormat;
    }

    public String getWhereThreeFormat() {
        return whereThreeFormat;
    }

    public String getJoinFormat() {
        return joinFormat;
    }

    public String getLimitFormat() {
        return limitFormat;
    }

    public String getDeleteSelectFormat() {
        return deleteSelectFormat;
    }

    public String getDeleteFrom() {
        return deleteFrom;
    }

    public String getInsertFormat() {
        return insertFormat;
    }

    public String getInsertMultipleFormat() {
        return insertMultipleFormat;
    }

    public String getUpdateFormat() {
        return updateFormat;
    }

    public String getUpdateMultipleFormat() {
        return updateMultipleFormat;
    }

    public String getDeleteFormat() {
        return deleteFormat;
    }

    public String getCreateString() {
        return createString;
    }
}
