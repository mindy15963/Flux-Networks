package sonar.flux.client.gui.buttons;

import net.minecraft.client.Minecraft;
import sonar.core.client.gui.SonarButtons.ImageButton;
import sonar.flux.FluxTranslate;
import sonar.flux.client.gui.GuiAbstractTab;
import sonar.flux.client.gui.tabs.GuiTabNetworkConnections;

import static net.minecraft.client.renderer.GlStateManager.color;

public class ConnectedBlocksButton extends ImageButton {
	public GuiTabNetworkConnections gui;

	public ConnectedBlocksButton(GuiTabNetworkConnections gui, int id, int x, int y) {
		super(id, x, y, GuiAbstractTab.large_buttons, 0, 34, 17, 17);
		this.gui = gui;
	}

	public void drawButtonForegroundLayer(int x, int y) {
		gui.drawSonarCreativeTabHoveringText(FluxTranslate.SORTING_SHOW_CONNECTED.t() + ": " + GuiTabNetworkConnections.showConnections, x, y);
	}

	public void drawButton(Minecraft mc, int x, int y, float partialTicks) {
		if (visible) {
			color(1.0F, 1.0F, 1.0F, 1.0F);
			hovered = x >= this.x && y >= this.y && x < this.x + width + 1 && y < this.y + height + 1;
			mc.getTextureManager().bindTexture(texture);
			drawTexturedModalRect(this.x, this.y, textureX, GuiTabNetworkConnections.showConnections ? textureY : textureY + 17, sizeX, sizeY);
		}
	}
}