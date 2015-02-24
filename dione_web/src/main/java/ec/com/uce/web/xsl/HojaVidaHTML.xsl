<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<!-- TODO: Auto-generated template -->
		<html>
			<center>
				<table width="100%" cellpadding="0" cellspacing="1"
					style="border: solid 1px #000000;">
					<tbody>
						<tr>
							<td>
								<table width="100%" cellpadding="0" cellspacing="5"
									style="font-size: 10pt;font-family: Verdana, Arial, Helvetica, sans-serif;">
									<tbody>
										<tr>
											<td>
												<b>
													<xsl:text>Hoja de Vida</xsl:text>
												</b>
												<br />
												<xsl:value-of select="mail/cedula" />
												<br />
												<xsl:value-of select="mail/nombre" />
												<br />
												<xsl:value-of select="mail/apellido" />
												<br />
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
							</td>
						</tr>
					</tbody>
				</table>
			</center>
		</html>
	</xsl:template>
</xsl:stylesheet>