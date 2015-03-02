<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<!-- TODO: Auto-generated template -->
		<html>
			<center>

				<table width="100%" cellpadding="0" cellspacing="5">
					<tbody>
						<tr>
							<td>
								<b>
									<xsl:text>Hoja de Vida</xsl:text>
								</b>
								<br />
								<xsl:text>Cedula de indetidad: </xsl:text>
								<xsl:value-of select="mail/cedula" />
								<br />
								<xsl:text>Nombre: </xsl:text>
								<xsl:value-of select="mail/nombre" />
								<br />
								<xsl:text>Apellido: </xsl:text>
								<xsl:value-of select="mail/apellido" />
								<br />
								<xsl:text>Direcci&#243;n: </xsl:text>
								<xsl:value-of select="mail/direccion" />
								<br />
							</td>
						</tr>
						<tr>
							<td height="5px">&#xA0;</td>
						</tr>

						<tr>
							<td height="10px">&#xA0;</td>
						</tr>
					</tbody>
				</table>

			</center>
		</html>
	</xsl:template>
</xsl:stylesheet>