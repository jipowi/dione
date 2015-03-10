<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/">
		<!-- TODO: Auto-generated template -->
		<html>
			<center>
				<table width="100%" cellpadding="0" cellspacing="5" border="0">
					<col style="width:80%;" />
					<tbody>
						<tr>
							<td align="center" colspan="2" style="font-weight: bold;">
								<h3>
									<xsl:text>Hoja de Vida</xsl:text>
								</h3>
							</td>
						</tr>
						<tr>
							<td style="height:1.0cm;"></td>
						</tr>
						<tr>
							<td>

								<br />
								<xsl:text>Cedula de indetidad: </xsl:text>
								<xsl:value-of select="documento/cedula" />
								<br />
								<xsl:text>Nombre: </xsl:text>
								<xsl:value-of select="documento/nombre" />
								<br />
								<xsl:text>Apellido: </xsl:text>
								<xsl:value-of select="documento/apellido" />
								<br />
								<xsl:text>Direcci&#243;n: </xsl:text>
								<xsl:value-of select="documento/direccion" />
								<br />
							</td>
						</tr>
						<tr>
							<td style="height:0.8cm;"></td>
						</tr>

						<tr>
							<td>
								<table width="100%" border="1" cellspacing="0"
									cellpadding="0" class="blanco">
									<col style="width:50%;" />
									<col style="width:50%;" />

									<tbody style="background-color: silver; font-weight: bold;">
										<tr>
											<td align="center" colspan="2" style="font-weight: bold;">
												<h3>
													<xsl:text> FORMACCION ACADEMICA </xsl:text>
												</h3>
											</td>
										</tr>

										<tr>
											<td align="center">
												<h4>
													<xsl:text>Institucion</xsl:text>
												</h4>
											</td>
											<td align="center">
												<h4>
													<xsl:text>Titulo</xsl:text>
												</h4>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="1" cellspacing="0"
									cellpadding="0" class="blanco">
									<col style="width:50%;" />
									<col style="width:50%;" />
									<tbody>

										<xsl:for-each select="documento/formacionAcademica">
											<tr>
												<td>
													<xsl:value-of select="institucionA" />
												</td>
												<td>
													<xsl:value-of select="titulo" />
												</td>
											</tr>
										</xsl:for-each>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td style="height:0.8cm;"></td>
						</tr>
						<!-- formacion Continua -->
						<tr>
							<td>
								<table width="100%" border="1" cellspacing="0"
									cellpadding="0" class="blanco">
									<col style="width:30%;" />
									<col style="width:30%;" />
									<col style="width:40%;" />
									<tbody style="background-color: silver; font-weight: bold;">
										<tr>
											<td align="center" colspan="3" style="font-weight: bold;">
												<h3>
													<xsl:text> FORMACCION CONTINUA </xsl:text>
												</h3>
											</td>
										</tr>

										<tr>
											<td align="center">
												<h4>
													<xsl:text>Curso</xsl:text>
												</h4>
											</td>
											<td align="center">
												<h4>
													<xsl:text>Duracion</xsl:text>
												</h4>
											</td>
											<td align="center">
												<h4>
													<xsl:text>Institucion</xsl:text>
												</h4>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="1" cellspacing="0"
									cellpadding="0" class="blanco">
									<col style="width:30%;" />
									<col style="width:30%;" />
									<col style="width:40%;" />
									<tbody>
										<xsl:for-each select="documento/formacionC">
											<tr>
												<td>
													<xsl:value-of select="curso" />
												</td>
												<td>
													<xsl:value-of select="duracion" />
												</td>
												<td>
													<xsl:value-of select="institucionC" />
												</td>
											</tr>
										</xsl:for-each>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td style="height:0.8cm;"></td>
						</tr>
						<!-- Experiencia -->
						<tr>
							<td>
								<table width="100%" border="1" cellspacing="0"
									cellpadding="0" class="blanco">
									<col style="width:40%;" />
									<col style="width:20%;" />
									<col style="width:20%;" />
									<col style="width:20%;" />
									<tbody style="background-color: silver; font-weight: bold;">
										<tr>
											<td align="center" colspan="4" style="font-weight: bold;">
												<h3>
													<xsl:text> EXPERIENCIA </xsl:text>
												</h3>
											</td>
										</tr>

										<tr>
											<td align="center">
												<h4>
													<xsl:text>Institucion</xsl:text>
												</h4>
											</td>
											<td align="center">
												<h4>
													<xsl:text>Fecha Inicio</xsl:text>
												</h4>
											</td>
											<td align="center">
												<h4>
													<xsl:text>Fecha Fin</xsl:text>
												</h4>
											</td>
											<td align="center">
												<h4>
													<xsl:text>Funciones</xsl:text>
												</h4>
											</td>
										</tr>
									</tbody>
								</table>
							</td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="1" cellspacing="0"
									cellpadding="0" class="blanco">
									<col style="width:40%;" />
									<col style="width:20%;" />
									<col style="width:20%;" />
									<col style="width:20%;" />
									<tbody>
										<xsl:for-each select="documento/experiencia">
											<tr>
												<td>
													<xsl:value-of select="institucionE" />
												</td>
												<td>
													<xsl:value-of select="fechaInicio" />
												</td>
												<td>
													<xsl:value-of select="fechaFin" />
												</td>
												<td>
													<xsl:value-of select="funcion" />
												</td>
											</tr>
										</xsl:for-each>
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