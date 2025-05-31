module Core {
    requires javafx.graphics;
    requires dk.sdu.cbse.common;
    requires spring.context;
    requires spring.core;
    requires spring.beans;
    opens dk.sdu.cbse.core to javafx.graphics, spring.core;
    uses dk.sdu.cbse.common.services.IPostService;
    uses dk.sdu.cbse.common.services.IGameService;
    uses dk.sdu.cbse.common.services.IEntityService;
    exports dk.sdu.cbse.core;
}
