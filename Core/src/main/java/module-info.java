module dk.sdu.cbse.core {
    requires javafx.graphics;
    requires dk.sdu.cbse.common;
    opens dk.sdu.cbse.core to javafx.graphics;
    uses dk.sdu.cbse.common.services.IPostService;
    uses dk.sdu.cbse.common.services.IGameService;
    uses dk.sdu.cbse.common.services.IEntityService;
}
