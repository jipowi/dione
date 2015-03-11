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
									<xsl:text>SYLLABUS</xsl:text>
								</h3>
							</td>
						</tr>
						<tr>
							<td style="height:1.0cm;"></td>
						</tr>
						<tr>
							<td>

								<br />
								<xsl:text>Asignatura: </xsl:text>
								<xsl:value-of select="documento/asignatura" />
								<br />
								<xsl:text>Horas presenciales: </xsl:text>
								<xsl:value-of select="documento/horasPresenciales" />
								<br />
								<xsl:text>Tutorias: </xsl:text>
								<xsl:value-of select="documento/horasTutorias" />
								<br />
								<xsl:text>Descripcion asignatura: </xsl:text>
								<xsl:value-of select="documento/desAsignatura" />
								<br />
							</td>
						</tr>
						<tr>
							<td style="height:0.8cm;"></td>
						</tr>
						<!-- PREREQUISITOS -->
						<tr>
							<td>
								<table width="100%" border="1" cellspacing="0"
									cellpadding="0" class="blanco">
									<col style="width:100%;" />

									<tbody style="background-color: silver; font-weight: bold;">
										<tr>
											<td align="center" colspan="2" style="font-weight: bold;">
												<h3>
													<xsl:text> PREREQUISITOS </xsl:text>
												</h3>
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
									<col style="width:100%;" />

									<tbody>
										<xsl:for-each select="documento/prerequisitos">
											<tr>
												<td>
													<xsl:value-of select="prerequisito" />
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
						<!-- COREQUISITOS -->
						<tr>
							<td>
								<table width="100%" border="1" cellspacing="0"
									cellpadding="0" class="blanco">
									<col style="width:100%;" />

									<tbody style="background-color: silver; font-weight: bold;">
										<tr>
											<td align="center" colspan="2" style="font-weight: bold;">
												<h3>
													<xsl:text> COREQUISITOS	 </xsl:text>
												</h3>
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
									<col style="width:100%;" />

									<tbody>
										<xsl:for-each select="documento/corequisitos">
											<tr>
												<td>
													<xsl:value-of select="corequisito" />
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
						<!-- OBJETIVOS -->
						<tr>
							<td>
								<table width="100%" border="1" cellspacing="0"
									cellpadding="0" class="blanco">
									<col style="width:100%;" />

									<tbody style="background-color: silver; font-weight: bold;">
										<tr>
											<td align="center" colspan="2" style="font-weight: bold;">
												<h3>
													<xsl:text> OBJETIVOS </xsl:text>
												</h3>
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
									<col style="width:100%;" />

									<tbody>
										<xsl:for-each select="documento/objetivos">
											<tr>
												<td>
													<xsl:value-of select="objetivo" />
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
						<!-- COMPETENCIAS GENERALES -->
						<tr>
							<td>
								<table width="100%" border="1" cellspacing="0"
									cellpadding="0" class="blanco">
									<col style="width:100%;" />

									<tbody style="background-color: silver; font-weight: bold;">
										<tr>
											<td align="center" colspan="2" style="font-weight: bold;">
												<h3>
													<xsl:text> COMPETENCIAS GENERALES </xsl:text>
												</h3>
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
									<col style="width:100%;" />

									<tbody>
										<xsl:for-each select="documento/comGenerales">
											<tr>
												<td>
													<xsl:value-of select="compGeneral" />
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
						<!-- COMPETENCIAS GENERICAS -->
						<tr>
							<td>
								<table width="100%" border="1" cellspacing="0"
									cellpadding="0" class="blanco">
									<col style="width:100%;" />

									<tbody style="background-color: silver; font-weight: bold;">
										<tr>
											<td align="center" colspan="2" style="font-weight: bold;">
												<h3>
													<xsl:text> COMPETENCIAS GENERICAS - Instrumentales </xsl:text>
												</h3>
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
									<col style="width:100%;" />

									<tbody>
										<xsl:for-each select="documento/comInstrumentales">
											<tr>
												<td>
													<xsl:value-of select="comInstrumental" />
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
						<tr>
							<td>
								<table width="100%" border="1" cellspacing="0"
									cellpadding="0" class="blanco">
									<col style="width:100%;" />

									<tbody style="background-color: silver; font-weight: bold;">
										<tr>
											<td align="center" colspan="2" style="font-weight: bold;">
												<h3>
													<xsl:text> COMPETENCIAS GENERICAS - Interpersonales </xsl:text>
												</h3>
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
									<col style="width:100%;" />

									<tbody>
										<xsl:for-each select="documento/comInterpersonales">
											<tr>
												<td>
													<xsl:value-of select="comInterpersonal" />
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
						<tr>
							<td>
								<table width="100%" border="1" cellspacing="0"
									cellpadding="0" class="blanco">
									<col style="width:100%;" />

									<tbody style="background-color: silver; font-weight: bold;">
										<tr>
											<td align="center" colspan="2" style="font-weight: bold;">
												<h3>
													<xsl:text> COMPETENCIAS GENERICAS - Sistematicas </xsl:text>
												</h3>
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
									<col style="width:100%;" />

									<tbody>
										<xsl:for-each select="documento/comSistematicas">
											<tr>
												<td>
													<xsl:value-of select="comSistematica" />
												</td>
											</tr>
										</xsl:for-each>
									</tbody>
								</table>
							</td>
						</tr>
						<!-- COMPETENCIAS ESPECIFICAS -->
						<tr>
							<td style="height:0.8cm;"></td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="1" cellspacing="0"
									cellpadding="0" class="blanco">
									<col style="width:100%;" />

									<tbody style="background-color: silver; font-weight: bold;">
										<tr>
											<td align="center" colspan="2" style="font-weight: bold;">
												<h3>
													<xsl:text> COMPETENCIAS ESPECIFICAS</xsl:text>
												</h3>
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
									<col style="width:100%;" />

									<tbody>
										<xsl:for-each select="documento/comEspecificas">
											<tr>
												<td>
													<xsl:value-of select="comEspecifica" />
												</td>
											</tr>
										</xsl:for-each>
									</tbody>
								</table>
							</td>
						</tr>

						<!-- BIBLIOGRAFIAS -->
						<tr>
							<td style="height:0.8cm;"></td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="1" cellspacing="0"
									cellpadding="0" class="blanco">
									<col style="width:100%;" />

									<tbody style="background-color: silver; font-weight: bold;">
										<tr>
											<td align="center" colspan="2" style="font-weight: bold;">
												<h3>
													<xsl:text> BIBLIOGRAFIAS</xsl:text>
												</h3>
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
									<col style="width:100%;" />

									<tbody>
										<xsl:for-each select="documento/bibliografias">
											<tr>
												<td>
													<xsl:value-of select="bibliografia" />
												</td>
											</tr>
										</xsl:for-each>
									</tbody>
								</table>
							</td>
						</tr>

						<!-- RESULTADOS -->
						<tr>
							<td style="height:0.8cm;"></td>
						</tr>
						<tr>
							<td>
								<table width="100%" border="1" cellspacing="0"
									cellpadding="0" class="blanco">
									<col style="width:100%;" />

									<tbody style="background-color: silver; font-weight: bold;">
										<tr>
											<td align="center" colspan="2" style="font-weight: bold;">
												<h3>
													<xsl:text> RESULTADOS DE APRENDIZAJE</xsl:text>
												</h3>
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
									<col style="width:100%;" />

									<tbody>
										<xsl:for-each select="documento/resultados">
											<tr>
												<td>
													<xsl:value-of select="resultado" />
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
						<!-- UNIDADES DE COMPETENCIA -->

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
													<xsl:text> UNIDADES DE COMPETENCIA </xsl:text>
												</h3>
											</td>
										</tr>
										<tr>
											<td align="center">
												<h4>
													<xsl:text>Unidad de competencia</xsl:text>
												</h4>
											</td>
											<td align="center">
												<h4>
													<xsl:text>Planificacion de horas por competencia</xsl:text>
												</h4>
											</td>
											<td align="center">
												<h4>
													<xsl:text>Elementos de competencia</xsl:text>
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
										<xsl:for-each select="documento/unidades">
											<tr>
												<td>
													<xsl:value-of select="unidadCompetencia" />
												</td>
												<td>
													<xsl:value-of select="horas" />
												</td>
												<td>
													<table width="100%" border="1" cellspacing="0"
														cellpadding="0" class="blanco">
														<col style="width:100%;" />
														<tbody>
															<xsl:for-each select="elementos">
																<tr>
																	<td>
																		<xsl:value-of select="elemento" />
																	</td>
																</tr>
															</xsl:for-each>
														</tbody>
													</table>
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
					</tbody>
				</table>
			</center>
		</html>
	</xsl:template>
</xsl:stylesheet>